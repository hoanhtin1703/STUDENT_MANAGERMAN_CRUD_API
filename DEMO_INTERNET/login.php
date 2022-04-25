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
    $query = "SELECT name FROM  account 
   WHERE user_name ='$user_name' AND  password='$password'";
$result = mysqli_query($conn,$query);

        if ( mysqli_num_rows($result) >0 )
        {
           while($row = mysqli_fetch_assoc($result)){
            $name = $row['name'];
           }
            $result_code ="Name is Avaiable";
         
                echo json_encode(array('status ' => 'true', 'result_code' =>$result_code,'name' => $name));
               

        } else 
        {
             
                $status = "false";
                $result_code ="Name is Non Avaiable";
                echo json_encode(array('status ' => $status, 'result_code' =>$result_code));
                
         }

}
}

        else 
        {
      
            mysqli_close($conn);

        }

        
?>