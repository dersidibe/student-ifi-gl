<?php 
	header('Content-type:text/xml');
	echo '<?xml version="1.0" encoding="utf-8"?>';	
	echo '<structure>';
	require('../Library/appLibrary.php');
	
	
	((isset($_GET['latitude']) && !empty($_GET['latitude'])) ? $latitude = $_GET['latitude'] : $latitude = '');
	((isset($_GET['longitude']) && !empty($_GET['longitude'])) ? $longitude = $_GET['longitude'] : $longitude = '');
	((isset($_GET['type']) && !empty($_GET['type'])) ? $type = $_GET['type'] : $type = '');

	if($latitude != "" && $longitude != ""){
		$f = new Fonction();	
		//$_select = $f->getPharmacie('21.041979', '105.782204'); 
		$_select = $f->getPharmacie($latitude, $longitude,1); 
					 		  
		foreach($_select as $_key){
					  
			echo '<item>';
				echo '<id>';
					echo $_key->getId();
				echo '</id>';
				echo '<nom>';
					echo "<![CDATA[".$_key->getName()."]]>";
				echo '</nom>';			
				echo '<latitude>';
					echo $_key->getLatitude();
				echo '</latitude>';
				echo '<longitude>';
					echo $_key->getLongitude();
				echo '</longitude>';
				echo '<telephone>';
					echo $_key->getTelephone();
				echo '</telephone>';
				echo '<rue>';
					echo "<![CDATA[".$_key->getRue()."]]>";
				echo '</rue>';
				echo '<distance>';
					echo $_key->getDistance();
				echo '</distance>';			
			echo "</item>";
		}
	}
			  
	echo '</structure>';

?>
