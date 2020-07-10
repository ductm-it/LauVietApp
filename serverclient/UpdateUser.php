<?php
include "connect.php";
$user_name = $_POST['user_name'];
$password = $_POST['password'];
$email = $_POST['email'];
$phone = $_POST['phone'];
$address = $_POST['address'];

$Sql_Query = "UPDATE account
 SET  email = '$email', phone = '$phone',address='$address'
  WHERE user_name = $user_name";

 if(mysqli_query($conn,$Sql_Query))
{
 echo 'Successfully';
}
else
{
 echo 'Something went wrong';
 }
 

?>