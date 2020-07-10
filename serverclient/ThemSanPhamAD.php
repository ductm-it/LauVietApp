

<?php
	require_once('connect.php');
	mysqli_set_charset($conn,'utf8');


        $id_type = $_POST['id_type'];
        $name =$_POST['name'];
        $price = $_POST['price'];
        $color = $_POST['color'];
        $material = $_POST['material'];
        $description = $_POST['description'];     
         
  
    
        $sqlInsert = "INSERT INTO product(id,name,id_type,price,color,material,description) 
                VALUES(null,'$name',$id_type,$price,'$color','$material','$description')";
        $resultInsert = mysqli_query($conn, $sqlInsert);
        if ($resultInsert) {
            $idsanpham=$conn->insert_id;
            echo  $idsanpham;
          

        } else {
           echo'that bai';
        }
            
      
        
    
	
?>

