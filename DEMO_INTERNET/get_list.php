<?php 

header("Content-Type: application/json; charset=UTF-8");

require_once 'config.php';

$query = "SELECT *,student.id as student_id FROM student INNER JOIN account ON account.id=student.account_id WHERE level =1 ORDER BY student.id DESC " ;
$result = mysqli_query($conn, $query);
$response = array();

$server_name = $_SERVER['SERVER_ADDR'];

while( $row = mysqli_fetch_assoc($result) ){

    array_push($response, 
    array(
        'user_name' =>$row['user_name'],
        'password' =>$row['password'],
        'account_id'=>$row['account_id'],
        'id'        =>$row['student_id'], 
        'name'      =>$row['name'], 
        'student_code'=>$row['student_code'],
        'grade'     =>$row['grade'],
        'major'    =>$row['major'],
        'date'     =>date('d M Y', strtotime($row['date'])),
        'image'   =>"http://$server_name".$row['image']
        ) 
    );
}


echo json_encode($response);

mysqli_close($conn);

?>