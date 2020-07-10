<?php
include "connect.php";
$page=$_GET['page'];
//$idsp=3;
$idsp=$_POST['id_type'];
$space=5;
$limit=($page-1)*$page;

$query="SELECT product.id,product.name,price,link,color,material,description,id_type
FROM images ,product_type,product
WHERE images.id_product=product.id and product.id_type=product_type.id and id_type= $idsp
LIMIT $limit,$space"; 



$data=mysqli_query($conn,$query);
$mangsanpham= array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangsanpham,new SanPham(
        $row['id'],
          $row['name'],
           $row['price'],
            $row['link'],
            $row['color'],
            $row['material'],
            $row['description'],
            $row['id_type']
             )); 

}
echo json_encode($mangsanpham);

class SanPham{
    function SanPham($id,$name,$price,$image,$color,$material,$description,$id_type)
    {
    $this->id=$id;
    $this->name=$name;
    $this->image=$image;
    $this->price=$price;
    $this->color=$color;
    $this->material=$material;
    $this->description=$description;
    $this->id_type=$id_type;
    }
}
?>