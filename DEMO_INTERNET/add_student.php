<?php 

require_once 'config.php';

$key = $_POST['key'];
$user_name  = $_POST['user_name'];
$password   = $_POST['password'];
$name       = $_POST['name'];
$student_code   = $_POST['student_code'];
$grade      = $_POST['grade'];
$major     = $_POST['major'];
$date      = $_POST['date'];
$image    = $_POST['image'];
$level = 1;
if ( $key == "insert" ){

    $birth_newformat = date('Y-m-d', strtotime($date));
    $query = "INSERT INTO account (user_name,password,level)
    VALUES ('$user_name', '$password', '$level')";
    if(mysqli_query($conn,$query)){
        $id = mysqli_insert_id($conn);
        $query = "INSERT INTO student (name,account_id,student_code,grade,major,date)
        VALUES ('$name','$id', '$student_code', '$grade', '$major', '$birth_newformat') ";
            if ( mysqli_query($conn, $query) ){
                if ($image == "") {
                    $finalPath = "/demo_internet/picture/images.png"; 
                    $result["value"] = "1";
                    $result["message"] = "Success";
                    echo json_encode($result);
                    mysqli_close($conn);
    
                } else {
    
                   
                    $path = "picture/$id.jpeg";
                    $finalPath = "/DEMO_INTERNET/".$path;
    
                    $insert_picture = "UPDATE student SET image='$finalPath' WHERE id='$id' ";
                
                    if (mysqli_query($conn, $insert_picture)) {
                
                        if ( file_put_contents( $path, base64_decode($image) ) ) {
                            
                            $result["value"] = "1";
                            $result["message"] = "Success!";
                
                            echo json_encode($result);
                            mysqli_close($conn);
                
                        } else {
                            
                            $response["value"] = "0";
                            $response["message"] = "Error! ".mysqli_error($conn);
                            echo json_encode($response);
    
                            mysqli_close($conn);
                        }
    
                    }
                }
    
            } 
            else {
                $response["value"] = "0";
                $response["message"] = "Error! ".mysqli_error($conn);
                echo json_encode($response);
    
                mysqli_close($conn);
            }
    }
    
}

?>