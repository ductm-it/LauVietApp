<?php
include "connect.php";
$page=$_GET['page'];
$space=5;
$limit=($page-1)*$space;

$query=" SELECT user_id,user_name,password,email,phone,address,quyen
FROM account
LIMIT $limit,$space"; 

$data=mysqli_query($conn,$query);
$mangtaikhoan= array();
while ($row=mysqli_fetch_assoc($data)) {
    array_push($mangtaikhoan,new TaiKhoan(
        $row['user_id'],
          $row['user_name'],
          $row['password'],
           $row['email'],
            $row['phone'],
            $row['address'],
            $row['quyen']
             )); 

}
echo json_encode($mangtaikhoan);

class TaiKhoan{
    function TaiKhoan($user_id,$user_name,$password,$email,$phone,$address,$quyen)
    {
    $this->user_id=$user_id;
    $this->user_name=$user_name;
    $this->password=$password;
    $this->email=$email;
    $this->phone=$phone;
    $this->address=$address;
    $this->quyen=$quyen;
  
    }
}
?>

