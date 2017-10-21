NOTE: I've updated the version of Serenity as I was having OSX Sierra compatibility issues with Chromedriver,
this solved it for me.
Also, screenshots are only taken on failure, at every step was overkill for me.
Running the tests remains the same as your set up, I went with the PAgeObject pattern for UI
 API tests are tagged as @api


## Running tests

To run all tests, run the command below:

`$ gradle clean test aggregate`

To run scenarios tagged as pageobject OR screenplay on Chrome: 

`$ gradle clean test aggregate -Dwebdriver.driver=chrome -Dcucumber.options="--tags @pageobject,@screenplay"` 

To run scenarios tagged as ui AND NOT wip on Safari: 
`$ gradle clean test aggregate -Dwebdriver.driver=safari -Dwebdriver.base.url=http://abc.com -Dcucumber.options="--tags @ui --tags ~@wip"`

## Reporting

View the report at target/site/serenity/index.html


