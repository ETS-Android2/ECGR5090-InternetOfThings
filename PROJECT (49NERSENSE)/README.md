## Android-IOT-RPI (49NERSENSE)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is a supposed level 1 IOT implementation. This repository contains a home utility android application, php docs, MySql Database Export File and python socketing codes implemented. Android Apphas the following features: a User Login and Registration page, User Interface for Home Devices, Live Camera Data Streaming and into local server, Weather Forecast using AccuWeather Api and Interaction with MySQL Database and Python Socket Programming from Local Server to raspberry pi. The 
	
## Technologies
Project is created with:
* Android Studio v4.1.1
* Xamp Server v3.2.4
* Notepad++
* Python 3.7
	
## Setup
To run this project, the following hardwares are required:
* Laptop with Linux/Windows
* Android device
* Router(AC1200 Dual Band Smart WiFi Router, Wireless AC 1200Mbps Router, 300 Mbps (2.4GHz)+867 Mbps (5GHz), Guest Network, QoS, Compatible with Amazon Alexa (WR1000))
* Raspberry Pi Camera Video Module 5 Megapixel 1080p
* Raspberry Pi 3 B+ (B Plus) Starter Kit

## Report
* The phase 1 of the project was completed successfully. The app was designed and implemented. The Xamp Server was successfully installed and the HTTP Server was setup. 3 MySQL databases for Sensor/Actuators, User Profiles and Thermostat were  created. An android app named 49nersense was designed and installed on te android phone. Was able to interact with the databases directly via a url and Php scripts. I was also able to implement a live cam stream but encounters with the video splitting.

* The phase 2 of the project was daughting as i was unable to establish a succesfull  transfer test socket connection with the c codes provided, tried implementing it in python but faced the same issue. Error has been added below.


* Phase 3 is non existant as i was unable to establish a successful data transfer via socket.

## Sources
This project was inspired by CPI inTouch app.
This project is a requirement for the 5090 Internet of Things Course at the University of North Carolina, Charlotte.
