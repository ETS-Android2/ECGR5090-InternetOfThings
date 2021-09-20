<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "49nersense";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$status = $_POST["action"];

switch ($status) {
	case "Floor1LightOn":
		$sql = "UPDATE senseactuat SET lightsFlr1 ='1' WHERE houseID=112";
		echo "Floor 1 Lights Switched On";
		break;
		
	case "Floor1LightOff":
		$sql = "UPDATE senseactuat SET lightsFlr1 ='0' WHERE houseID=112";
		echo "Floor 1 Lights Switched Off";
		break;
		
	case "Floor2LightOn":
		$sql = "UPDATE senseactuat SET lightsFlr2 ='1' WHERE houseID=112";
		echo "Floor 2 Lights Switched On";
		break;
	
	case "Floor2LightOff":
		$sql = "UPDATE senseactuat SET lightsFlr2 ='0' WHERE houseID=112";
		echo "Floor 2 Lights Switched Off";
		break;
	
	case "garageDoorUnlock":
		$sql = "UPDATE senseactuat SET 	lockGrgdoors ='1' WHERE houseID=112";
		echo "G Door Unlock";
		break;
	
	case "garageDoorLock":
		$sql = "UPDATE senseactuat SET 	lockGrgdoors ='0' WHERE houseID=112";
		echo "G Door Lock";
		break;
	
	case "frontDoorUnlock":
		$sql = "UPDATE senseactuat SET 	lockFrontDoor ='1' WHERE houseID=112";
		echo "Front Door Unlock";
		break;
	
	case "frontDoorLock":
		$sql = "UPDATE senseactuat SET lockFrontDoor ='0' WHERE houseID=112";
		echo "Front Door lock";
		break;
	
	case "backDoorUnlock":
		$sql = "UPDATE senseactuat SET lockBackDoor ='1' WHERE houseID=112";
		echo "Back Door Unlock";
		break;
	
	case "backDoorLock":
		$sql = "UPDATE senseactuat SET lockBackDoor ='0' WHERE houseID=112";
		echo "Back Door lock";
		break;
	
	case "garage1Open":
		$sql = "UPDATE senseactuat SET gdoor1 ='1' WHERE houseID=112";
		echo "Garage 1 Open";
		break;
	
	case "garage1Close":
		$sql = "UPDATE senseactuat SET gdoor1 ='0' WHERE houseID=112";
		echo "Garage 1 Close";
		break;
	
	case "garage2Open":
		$sql = "UPDATE senseactuat SET gdoor2 ='1' WHERE houseID=112";
		echo "Garage 2 Open";
		break;
	
	case "garage2Close":
		$sql = "UPDATE senseactuat SET gdoor2 ='0' WHERE houseID=112";
		echo "Garage 2 Close";
		break;
		
	case "secArmedHome":
		$sql = "UPDATE senseactuat SET sensorFlr2='0',sensorFlr1='0',motionDtctFlr2='0',motionDtctFlr1='0',gdoor2 ='0',gdoor1 ='0',lockBackDoor ='0',lockFrontDoor ='0',lockGrgdoors ='0', secStatus = '1' WHERE houseID=112";
		echo "Security Armed Home Status";
		break;
		
	case "secArmedAway":
		$sql = "UPDATE senseactuat SET sensorFlr2='1',sensorFlr1='1',motionDtctFlr2='1',motionDtctFlr1='1',gdoor2 ='0',gdoor1 ='0',lockBackDoor ='0',lockFrontDoor ='0',lockGrgdoors ='0',lightsFlr1 ='0', lightsFlr2 ='0', secStatus = '2' WHERE houseID=112";
		echo "Security Armed Away Status";
		break;
		
	case "secDisarmed":
		$sql = "UPDATE senseactuat SET sensorFlr2='0',sensorFlr1='0',motionDtctFlr2='0',motionDtctFlr1='0',lockBackDoor ='1',lockFrontDoor ='1',lockGrgdoors ='1', secStatus = '0' WHERE houseID=112";
		echo "Security Disarmed Status";
		break;
	
	default:
		echo "Invalid Device";
	
}		

if ($conn->query($sql) === TRUE) {
  echo "  Record updated successfully";
} else {
	
  echo "Error updating record: " . $connection->error;

}

$conn->close();
?>