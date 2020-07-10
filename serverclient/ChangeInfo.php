<?php


    include "connect.php";


$user_id = $_POST['user_id'];
 $user_name = $_POST['user_name'];
 $email = $_POST['email'];
 $phone = $_POST['phone'];
 $address = $_POST['address'];
//  $user_id = 1;
//  $user_name ='Tra';
//  $email = 'Tra908@gmail.com';
//  $phone = '123456789';
//  $address = 'Quang Nam';

$Sql_Query = "UPDATE account 
SET user_name= '$user_name', email = '$email', phone = '$phone', address = '$address'
WHERE user_id = $user_id";

 if(mysqli_query($conn,$Sql_Query))
{
    echo "1";
}
else
{
    echo "0";
 }
 

?>
