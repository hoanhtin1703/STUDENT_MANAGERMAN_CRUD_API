<?php 

require_once 'config.php';

$key = $_POST['key'];
$user_name  = $_POST['user_name'];
$password   = $_POST['password'];
$user_id    = $_POST['account_id'];
$id         = $_POST['id'];
$name       = $_POST['name'];
$student_code   = $_POST['student_code'];
$grade      = $_POST['grade'];
$major     = $_POST['major'];
$date      = $_POST['date'];
$image    = $_POST['image'];

if ( $key == "update" ){

    $birth_newformat = date('Y-m-d', strtotime($date));
    $query = "UPDATE student SET 
                                name ='$name'
                                ,student_code='$student_code'
                                ,grade='$grade'
                                ,major='$major'
                                ,date='$birth_newformat'
                                WHERE id = '$id' ";
        if ( mysqli_query($conn, $query) ){
            $sql = "UPDATE account SET user_name = '$user_name' , password ='$password' WHERE id ='$user_id'";
            mysqli_query($conn,$sql);
            if ($image == null) {

                
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

?>