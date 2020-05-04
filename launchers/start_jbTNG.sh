#!/bin/sh
java -Djava.util.logging.config.file=config/jbtng.logging.properties -jar jbTNG-@version@.jar -c config/javabottng.properties
