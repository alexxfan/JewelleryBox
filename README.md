# Jewellery Box Management System 

## Overview

This repository contains the code and documentation for the "Jewellery Store Management System" project, which is a part of the "Data Structures and Algorithms 1" module. The project is implemented in Java and focuses on building a jewellery store management system using custom-built internal data structures.

## Project Description

The objective of this project is to create a comprehensive jewellery store management system that allows users to manage a jewellery store with multiple display cases, display trays and jewellery items. The core features of the system include:

- **Display Cases**: Users can add new display cases with unique identifiers, types (wall-mounted or freestanding), and lighting options (lit or unlit).

- **Display Trays**: Display trays can be added to display cases, each with a unique identifier, inlay material color, and dimensions (width x depth).

- **Jewellery Items**: Users can add jewellery items to display trays, specifying properties such as item description, type (ring, watch, necklace, etc.), target gender (male, female, unisex), image URL and retail price.

- **Materials/Components**: Materials or components can be added to jewellery items, including properties like name/type (e.g., gold, platinum, diamonds), description, quantity/amount/weight and quality.

- **Removal**: Users can remove jewellery items and the system can calculate the value of individual display cases and trays.

- **Persistence**: The system supports saving and loading data to/from files, ensuring data persistence between executions.
  
- **Search Functionality**: Allows users to search for jewellery items by text, providing search results with item locations and full descriptions.

- **User Interface**: An interactive JavaFX graphical user interface is implemented to interact with the system.

- ## Setting up

To run the London Underground Route Finder application:

   ```bash
   git clone https://github.com/alexxfan/JewelleryBox.git
   cd JewelleryBox
   java -jar target/JewelleryBox.jar
