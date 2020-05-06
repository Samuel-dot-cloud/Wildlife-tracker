# PROJECT NAME.
The project is titled 'wildlife-tracker'. The project basically functions as the title suggests.For more information check out the following link:https://wildlife-tracker-5.herokuapp.com/
:paw_prints::paw_prints::paw_prints:

## AUTHOR NAME.
My name is Samuel and i am currently a learning software programmer at Moringa School.:man_technologist::man_technologist:

## DESCRIPTION OF PROJECT.
The project is a Java web application built with the spark framework whereby people are able to report sightings of both wild and endangered animals to a wildlife conservancy, as part of an effort to conserve a forest's ecosystem.:badger::badger:

### PROJECT SETUP INSTRUCTIONS.
1. Fork this repository.
2. Clone this repository onto your local machine through use of the command `git clone <Forked-repository-link.>`. 
3. Navigate to your terminal.
4. Navigate the the appropriate directory by use of cd command `cd<root-folder>`.
5. In order to make any additional changes to the project, it is highly adviced that you install an appropriate IDE(Integrated Development Environment).

### DATABASE SETUP INSTRUCTIONS.
- While in psql:
- `CREATE DATABASE wildlife_tracker;`
- `\c wildlife_tracker`
- `CREATE TABLE animals (id serial PRIMARY KEY, ranger_name VARCHAR,animal_name VARCHAR,health VARCHAR, age VARCHAR, location VARCHAR);`
- `CREATE TABLE sightings (id SERIAL PRIMARY KEY, ranger_name VARCHAR, animal_name VARCHAR,health VARCHAR, age VARCHAR, location VARCHAR); `
- `CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;`

### TECHNOLOGIES USED.
- Java.
- Gradle.
- JUnit.
- Handlebars.
- Spark.
- Heroku web hosting service.
- Bootstrap.

### KNOWN BUGS.
---------------

### CONTACT INFORMATION.
For more information, feel free to contact me through the email address: samdot@gmail.com

### LICENCE AND COPYRIGHT INFORMATION.
Copyright(c) 2020-present

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


