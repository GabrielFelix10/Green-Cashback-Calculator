$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/behavior/calculateCashback.feature");
formatter.feature({
  "name": "Calculate Cashback",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have 8 plastic bottles",
  "keyword": "Given "
});
formatter.match({
  "location": "CashBackCalculatorStepDefs.i_have_plastic_bottles(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I finish to put all they in  machine",
  "keyword": "When "
});
formatter.match({
  "location": "CashBackCalculatorStepDefs.i_finish_to_put_all_they_in_machine()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the machine must give 0.64 in cashback",
  "keyword": "Then "
});
formatter.match({
  "location": "CashBackCalculatorStepDefs.the_machine_must_give_in_cashback(Double)"
});
formatter.result({
  "status": "passed"
});
});