<?php
include "connect.php";
$query="SELECT product.id,product.name,price,link,color,material,description,id_type
FROM images ,product_type,product
WHERE images.id_product=product.id and product.id_type=product_type.id
ORDER BY product.id 
DESC LIMIT 6";



$data=mysqli_query($conn,$query);
$mangspmoi=array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangspmoi,new SanPhamMoi(
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
echo json_encode($mangspmoi);

class SanPhamMoi{
    function SanPhamMoi($id,$name,$price,$image,$color,$material,$description,$id_type)
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