Story: Trader

Scenario: trader is not alerted below threshold 
Given a stock of symbol <symbol> and a threshold of <threshold>
When the stock is traded at <price>
Then the alert status should be <status>

Examples:
|symbol|threshold|price|status
|STK|10|5|OFF|
|ATK|10|9|OFF|
|STK|10|1|OFF|
