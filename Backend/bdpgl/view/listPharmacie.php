<?php 
	header('Content-type:text/xml');
	echo '<?xml version="1.0" encoding="utf-8"?>';	
	include('../Library/appLibrary.php');
	
	$f = new Fonction();
	((isset($_GET['latitude']) && !empty($_GET['latitude'])) ? $latitude = $_GET['latitude'] : $latitude = '');
	((isset($_GET['longitude']) && !empty($_GET['longitude'])) ? $longitude = $_GET['longitude'] : $longitude = '');

	$select = $_f->getStructure($latitude, $longitude); 
			 		  
?>