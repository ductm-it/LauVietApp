<?php
include "connect.php";


$query = "SELECT DISTINCT product.id, name, SUM(quantity) as soluongsp
FROM product, bill_detail
WHERE product.id=bill_detail.id_product
GROUP BY id_product
ORDER BY soluongsp DESC limit 5";

$data=mysqli_query($conn,$query);
$mangsanpham= array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangsanpham,new SanPham(
        $row['id'],
          $row['name'],          
            $row['soluongsp']
                      
             )); 

}
echo json_encode($mangsanpham);

class SanPham
{
    public function SanPham($id, $name, $soluongsp)
    {
        $this->id=$id;
        $this->name=$name;       
        $this->soluongsp=$soluongsp;
     
      
    }
}


?>

