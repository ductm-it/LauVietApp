<?php
include "connect.php";
 $json=$_POST['json'];
// $json='[{"id_bill":53,"id_product":23,"quantity":1,"price":123},
// {"id_bill":54,"id_product":20,"quantity":3,"price":125}]';
$data=json_decode($json,true);
foreach ($data as $value) {
   $id_bill=$value['id_bill'];
   $id_product=$value['id_product'];
   $quantity=$value['quantity'];
   $price=$value['price'];  
   $query="INSERT INTO bill_detail (id,id_bill,id_product,quantity,price) 
    VALUES(null,'$id_bill','$id_product', '$quantity','$price')";
$DB=mysqli_query($conn,$query);
}
if ($DB) {
   
    echo "1";
}else{
    echo "0";
}
?>