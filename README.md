<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a id="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">

<h3 align="center"><a href="https://ulfgarstoolbox.click">Ulfgar's Toolbox</a></h3>

  <p align="center">
    Set of tools to use in a D&D3.5 game
    <br />
    ·
    <a href="https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
    <a href="https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project


### Tools

* [![Java][Java.com]][Java-url]
* [![Spring][Spring.io]][Spring-url]
* [![MySQL][MySQL.com]][MySQL-url]
* [![Jira][Jira.com]][Jira-url]
* [![Postman][Postman.com]][Postman-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Installation

<b>Clone the repo</b>
   ```sh
   git clone https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend.git
   ```
<b> Add environment variables in your IDE</b>
    <br />
  ⚠️ Make sure to update the variables according to your setup ⚠️
    <br />
	In IntelliJ IDEA, you can add environment variables by following these steps:

1. Go to `Run` > `Edit Configurations...`
2. Click on the `Environment Variables` field
3. If you don't have any environment variables yet, click on the `Modify options` button
4. You will see under `Operating System` -> `Environment Variables` click on it
5. Copy-paste the environment variables there (and possibly update them according to your setup)

Copy-paste the following environment variables in your IDE:

	### Server Configuration ###
	SERVER_PORT=8080
	
	### Database Configuration ###
	DATABASE_URL=jdbc:mysql://localhost:3066/dnd35
	DATABASE_USERNAME=root
	DATABASE_PASSWORD=root
	DATABASE_DRIVER=com.mysql.cj.jdbc.Driver
	
	# This will every time drop and create the database schema
	DATABASE_DDL_AUTO=update
	
	DATABASE_SHOW_SQL=true
	DATABASE_FORMAT_SQL=true
	
	### JWT Configuration ###
	JWT_ALGORITHM=HmacSHA256
	
	# Secret key for JWT that needs to be more than 256 bits (meaning 32 characters or more)
	JWT_SECRET=AZZ_PROJECT_SECRET_KEY_1234567890
	
	# 24 hours expiration time for JWT in milliseconds
	JWT_EXPIRE_AT=86400000
	
	# Front End Cors
	ANGULAR_ALLOWED_ORIGINS=http://localhost:4200
 
4. Run the SQL scripts located in the data-init folder

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Azzedine Hassaini - azzedinehassaini@gmail.com

Project Link: [https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend](https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/AzzedineHassaini/Ulfgar-s-Toolbox-Backend.svg?style=for-the-badge
[contributors-url]: https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/AzzedineHassaini/Ulfgar-s-Toolbox-Backend.svg?style=for-the-badge
[forks-url]: https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend/network/members
[stars-shield]: https://img.shields.io/github/stars/AzzedineHassaini/Ulfgar-s-Toolbox-Backend.svg?style=for-the-badge
[stars-url]: https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend/stargazers
[issues-shield]: https://img.shields.io/github/issues/AzzedineHassaini/Ulfgar-s-Toolbox-Backend.svg?style=for-the-badge
[issues-url]: https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend/issues
[license-shield]: https://img.shields.io/github/license/AzzedineHassaini/Ulfgar-s-Toolbox-Backend.svg?style=for-the-badge
[license-url]: https://github.com/AzzedineHassaini/Ulfgar-s-Toolbox-Backend/blob/master/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/azzedinehassaini/
[product-screenshot]: images/screenshot.png
[Spring.io]: https://img.shields.io/badge/Spring-0769AD?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/
[MySQL.com]: https://img.shields.io/badge/MySQL-0769AD?style=for-the-badge&logo=MySQL&logoColor=white
[MySQL-url]: https://www.mysql.com/
[Java.com]: https://img.shields.io/badge/Java-0769AD?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/
[Jira.com]: https://img.shields.io/badge/Jira-0769AD?style=for-the-badge&logo=jira&logoColor=white
[Jira-url]: https://www.jira.com/
[Postman.com]: https://img.shields.io/badge/Postman-0769AD?style=for-the-badge&logo=Postman&logoColor=white
[Postman-url]: https://www.postman.com/

