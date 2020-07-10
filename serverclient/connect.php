<?php
$host="localhost";
$username="root";
$password="";
$database="shop1";

$conn=mysqli_connect($host,$username,$password,$database);

mysqli_query($conn,"SET NAME 'utf8'");

?>