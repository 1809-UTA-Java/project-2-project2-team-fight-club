# Team Fight Club
This application integrates five Spring Boot applications to create teams composed of starwars characters and pokemon characters by typing a battle command in a Slack thread. The main feature occurs when a battle command is entered, and the applications picks to random teams to fight.
### Getting Started
1. Create a JDBC connection and run the ddl.sql and the dml.slq files found in the sql directory. 
1. Open and run all projects under the Spring directory using Eclipse or the Spring Tool Suite.
1. Open the Mule application using Anypoint Studio. 
1. Retrieve a legacy token for your Slack account.
1. Configure the Slack Connector with the token. 
1. Run the Mule application. 
1. Type 'Create user' in a Slack thread to create a random team.
1. Type 'Battle' to pick two challengers and to display the winner. 
### Requirements
- Mule Server 3.9.0 CE
- Maven
- Spring Boot 
- Slack Connector v3.5
### Authors
- Cody Phillips
- Glenn Cariaga
- Eduardo Juarez
- Lucas White 
- Ricardo Aranda
### Links

Please refer to the slide for more information about the project:
https://docs.google.com/presentation/d/1uGo9CPwzASG7DsVoKs9DrS6PCBhcf0HbRWl0Vjdhu4A/edit?usp=sharing
