

<?php
	

    include "connect.php";
/** Array for JSON response*/
$response = array();
if($_SERVER['REQUEST_METHOD']=='POST'){
    $username = $_POST['username'];
    $password = $_POST['password'];
    $sql = "SELECT * FROM account WHERE user_name = '$username' AND password='$password'AND quyen='khachhang'";
    if(mysqli_num_rows(@mysqli_query($conn,$sql)) > 0){
            $result= mysqli_query($conn,$sql);
            $row = mysqli_fetch_array($result);
            $user_id = $row["user_id"];
            $user_name = $row["user_name"];
            $email = $row["email"];
            $phone = $row["phone"];
            $address = $row["address"];
            
            $response["success"] = 1;
            $response["message"] = "Đăng nhập thành công";
            $response["user_id"] = $user_id;
            $response["user_name"] = $user_name;
            $response["email"] = $email;
            $response["phone"] = $phone;
            $response["address"] = $address;
         
    }else{
        $response["success"] = 0;
        $response["message"] = "Đăng nhập thất bại.";
    }
    /**Return json*/
    echo json_encode($response);
} 
?>