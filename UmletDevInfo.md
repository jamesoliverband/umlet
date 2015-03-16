# Release Tests #
Before every release the following parts of UMLet should be tested:
  * Batch-Start (eg: "-action=convert -format=pdf -filename=C:/`*`.uxf -output=C:\")
  * Grouping and Selectionhandling of elements
  * Export to pdf and bmp
  * Custom Elements (make sure there are no compile errors)
  * Eclipse Plugin working

# Project description #
|Baselet|Project for swing, batch and plugin versions. also read README.txt in project directory and use ant.xml for building releases (note: version number must be manually set|
|:------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|BaseletGWT|Project for GWT version with own ant.xml file|
|BaseletElements|Project which contains the shared code of both other projects. Mainly the NewGridElement classes and their Facets|