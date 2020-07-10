

<?php


    include "connect.php";


$id = $_POST['id'];
 $name = $_POST['name'];
 $id_type = $_POST['id_type'];
 $price = $_POST['price'];
 $color = $_POST['color'];
 $material = $_POST['material'];
 $description = $_POST['description'];

$Sql_Query = "UPDATE product 
SET  name = '$name', id_type = '$id_type', price = '$price',
color = '$color', material = '$material',description = '$description'
WHERE id = $id";

 if(mysqli_query($conn,$Sql_Query))
{
    echo "cập nhật thành công";
}
else
{
    echo "cập nhật không thành công";
 }
 

?>

