

<?php
include "connect.php";
$user_id = $_POST['user_id'];
$user_name = $_POST['user_name'];
$password = $_POST['password'];
$email = $_POST['email'];
$phone = $_POST['phone'];
$address = $_POST['address'];
$quyen	 = $_POST['quyen'];


$Sql_Query = "UPDATE account 
SET  user_name = '$user_name', password = '$password', email = '$email',
phone = '$phone', address = '$address',quyen = '$quyen'
WHERE user_id = $user_id";

if(mysqli_query($conn,$Sql_Query))
{
echo "cập nhật thành công";
}
else
{
echo "cập nhật không thành công";
}


?>

