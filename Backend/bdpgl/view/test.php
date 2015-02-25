<?php
header('Content-type=application/json; charset=utf-8');
require('../Library/appLibrary.php');

$f = new Fonction();
 echo $f->getPharmacie('21.041979', '105.782204');

?>
