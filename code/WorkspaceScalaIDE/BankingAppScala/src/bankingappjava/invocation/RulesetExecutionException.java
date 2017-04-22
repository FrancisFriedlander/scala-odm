//      -----------------------------------------------------------------------
//      Licensed Materials - Property of IBM
//      IBM Decision Server
//      (c) Copyright IBM Corporation 1987, 2017. All Rights Reserved.
//      RuleApp: BankingRuleapp
//      Date: Apr 20, 2017, 10:36:34 PM
//      Generated by: Decision Server 8.9.0.0
//
//      N O T I C E
//
//      Changes to this file will be lost if the code is regenerated.
//      Note to U.S. Government Users Restricted Rights: 
//      Use, duplication or disclosure restricted by GSA ADP Schedule 
//      Contract with IBM Corp.
//     -----------------------------------------------------------------------

package bankingappjava.invocation;

/**
 * Raised when a ruleset invocation fails
 */
public class RulesetExecutionException extends Exception {
	private static final long serialVersionUID = 1L;
	private String rulesetName;
	private Throwable cause;

	/**
	 * Raised when a ruleset invocation fails
	 */
	public RulesetExecutionException(String rulesetName, Throwable cause) {
		this.rulesetName = rulesetName;
		this.cause = cause;
	}

	/**
	 * Returns the cause of the exception
	 */
	public Throwable getCause() {
		return cause;
	}

	/**
	 * Returns the name of the ruleset
	 */
	public String getRulesetName() {
		return rulesetName;
	}
}