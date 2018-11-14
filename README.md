# rpncaculator
## How to
* git clone git@github.com:firstblood1985/rpncaculator.git
* import into moden IDE as Maven project
* let IDE resolve dependency
* run RpncaculatorApplication
## To do
* float precision is yet to consider
* unit test coverage
## How to add new operator
* decide it is one number operator like sqrt, or two number operator like plus. for example if one number operator, extends OneNumberOperator
* add one enum type in enum Operators
* create bean within AppConfig 
