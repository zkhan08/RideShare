The RideShare program simulates a dynamic ride-sharing system where passengers wait at various stations, and cars pick them up and take them to their destinations. I ran two different scenarios to test how the system handles different passenger and car loads. In both simulations, the cars moved along their predefined routes, picking up passengers based on their starting and destination stations. The output showed how the cars responded to passengers’ needs, making decisions about when to pick them up, where to drop them off, and whether they needed to reverse direction.

What I’m particularly proud of in this project is how the program models the interactions between the Car, Person, and Station classes. I’m happy with how clearly the program tracks passenger movement and how it manages the flow of cars at different stations. Each class plays a crucial role in keeping the simulation running smoothly. One of the biggest challenges I faced was ensuring that passengers were correctly picked up and dropped off according to the rules I set. For example, making sure that cars didn’t pick up passengers who were headed in the opposite direction took some fine-tuning. Also, handling edge cases—like when cars are full or when stations are empty—was a bit tricky, but resolving these issues made the program feel much more polished and realistic. 

In terms of the actual program running itself, the Tester.java file is written to allow the editing of the simulation of the program on lines 6-7, where you can edit the number of cars and people.

On average throughout ten simulations of each scenario, running it with 50 people and 20 cars resulted in 11%, and 50 people and 40 cars resulted in 21.6%, so we can see that more cars positively correlates with more completed passenger paths.