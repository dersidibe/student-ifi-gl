<?php
header('Content-type=application/json; charset=utf-8');
require('../Library/appLibrary.php');

$f = new Fonction();
 var_dump($f->getPharmacie('21.041979', '105.782204',1));

?>
http://fasoroom.nts-solution.net/view/