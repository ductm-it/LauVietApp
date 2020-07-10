<?php
include "connect.php";
$page=$_GET['page'];


$space=5;
$limit=($page-1)*$space;

$query=" SELECT product.id,product.name,price,link,color,material,description,id_type
FROM images ,product_type,product
WHERE images.id_product=product.id and product.id_type=product_type.id
LIMIT $limit,$space"; 



$data=mysqli_query($conn,$query);
$mangsanpham= array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangsanpham,new SanPham(
        $row['id'],
          $row['name'],
           $row['price'],
            $row['link'],
            $row['description'],
            $row['color'],
            $row['material'],
            $row['id_type']
             )); 

}
echo json_encode($mangsanpham);

class SanPham{
    function SanPham($id,$name,$price,$image,$description,$color,$material,$id_type)
    {
    $this->id=$id;
    $this->name=$name;
    $this->image=$image;
    $this->price=$price;
    $this->description=$description;
    $this->color=$color;
    $this->material=$material;
    $this->id_type=$id_type;
    }
}
?>