<?php
include "connect.php";
$id_customer =$_POST['id_customer'];
$date_order =$_POST['date_order'];
$total =$_POST['total'];
// $id_customer ='4';
// $date_order ='2020-05-13';
// $total ='1';
$query="INSERT INTO bill(id,id_customer,date_order,total,note,status)
 VALUES(null,'$id_customer','$date_order','$total',null,'chua giao')";
if (mysqli_query($conn,$query)) {
    $iddonhang=$conn->insert_id;
    echo  $iddonhang;
}else{
    echo "Bạn hãy đăng nhập";
}


?>