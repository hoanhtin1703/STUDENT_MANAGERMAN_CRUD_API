<?php 

require_once 'config.php';

$key = $_POST['key'];
$user_name  = $_POST['user_name'];
$password   = $_POST['password'];
if ( $key == "login" ){  
    if( $user_name =="" || $password==""){
        echo json_encode(array( "status" => "false","result_code" => "Parameter missing!") );
    }
    else{
        // echo json_encode(array( "status" => "true","result_code" => "Đã Nhận!","user_name"=>$user_name,"password"=>$password
        // ) );
$sql = "SELECT * FROM account WHERE user_name ='$user_name' AND password='$password'";
$result = mysqli_query($conn,$sql);
        if (mysqli_num_rows($result)>0)
        {
            $row = mysqli_fetch_assoc($result);
            $id = $row['id'];
            $level = $row ['level'];
            $query = "SELECT * FROM student WHERE  account_id ='$id'";
            if($result1 = mysqli_query($conn, $query)){
            $server_name = $_SERVER['SERVER_ADDR'];
            $row1 = mysqli_fetch_assoc($result1) ;

                    $status         ="true";
                    $user_id        =$row1['id'];
                    $name           =$row1['name'];
                    $student_code   =$row1['student_code'];
                    $grade          =$row1['grade'];
                    $major          =$row1['major'];
                    $date          =date('d M Y',strtotime($row1['date']));
                    $image          ="http://$server_name".$row1['image'];
                echo json_encode(array( "status" => $status,
                                        "level" =>$level,
                                        "id"   =>$id,
                                        "user_id"=>$user_id,
                                        "name" =>$name,
                                        "student_code"=>$student_code,
                                        "grade" =>$grade,
                                        "major"=>$major,
                                        "date"=>$date,
                                        "image"=>$image));
            }
        } else 
        {
              
                echo json_encode(array("status" => "false", 'result_code' =>'Khong co tai khoan '));
         }
        }
}
    

        else 
        {
            mysqli_close($conn);
        }

        
?>