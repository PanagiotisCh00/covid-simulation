# COVID-19 Spread Simulation
Project Overview

This project simulates the spread of a viral epidemic (such as COVID-19) within a population using object-oriented programming principles. The simulation models how the virus transmits between individuals within a spatial grid, taking into account factors such as proximity, movement, and infection probability.

The goal is to explore the impact of random movements, different infection rates, and various initial conditions on the overall spread of the virus across multiple regions, with each region interconnected.
Features

    Object-Oriented Design: The simulation is designed using Java, focusing on classes representing different objects such as individuals, regions, and the virus itself.
    Inter-Region Movement: Individuals can move randomly within regions and across neighboring regions, following predefined border rules.
    Infection Modeling: The virus can be transmitted between individuals in neighboring cells or through contact with infected areas.
    Multiple Zones: The simulation supports multiple regions, each with configurable size, population, and neighboring areas.
    Health Measures: The model includes parameters such as immunity, personal protection measures (like masks), and the ability to simulate quarantine zones and healthcare capacity.
    Graphical Output: The project includes graphical visualization of the simulation, displaying the evolution of infection in real time using the StdDraw library.

How It Works

    Population Initialization: Individuals are randomly placed in different regions, with each region configured based on its size and population density.
    Random Movement: Individuals move randomly within the grid. If they reach the edge of their region, they may cross into neighboring regions.
    Virus Transmission: Individuals in close proximity to infected individuals or infected areas have a chance of becoming infected. The infection probability is higher for direct contact between individuals than for environmental contamination.
    Simulation Parameters:
        Grid Dimensions: You can specify the size of each region.
        Infection Probability: Different probabilities for person-to-person transmission and area contamination.
        Initial Conditions: Number of initially infected individuals and population density.
    Healthcare and Quarantine: The simulation includes healthcare capacities and quarantine zones to isolate infected individuals and manage severe cases.

Credits

This project was developed as part of the Object-Oriented Programming course (EPL133) at the University of Cyprus, under the supervision of Prof. Marios Dikaiakos.
