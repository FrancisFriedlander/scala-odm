package bankingapp

import banking_scala_xom.Customer;
import bankingappjava.invocation.CheckCustomerOperationExecution;
import banking_scala_xom.CustomerOwningAssets
import banking_scala_xom.Asset

class MainScala {
  var checkCustomerOperationExecution = new CheckCustomerOperationExecution

  def run(customer: Customer) = {
    checkCustomerOperationExecution setCustomer customer
    checkCustomerOperationExecution run ()
    println("***" + customer.alerts)
  }
}

object MainScala extends App {
  var mainScala = new MainScala

  var customer = new Customer(-11)
  mainScala run customer
  // Expecting: "the total balance is less than -10"

  var assets = Array(new Asset(50), new Asset(50))
  customer = new CustomerOwningAssets(-10, assets)
  mainScala run customer
  // Expecting: nothing

  assets = Array(new Asset(50), new Asset(50), new Asset(1))
  customer = new CustomerOwningAssets(-10, assets)
  mainScala run customer
  // Expecting: "the sum of the asset values is more than 100"

  assets = Array(new Asset(100))
  customer = new CustomerOwningAssets(-10, assets)
  mainScala run customer
  // Expecting: "there is at least one asset where the value is more than 60"

  assets = Array(new Asset(100), new Asset(1))
  customer = new CustomerOwningAssets(-10, assets)
  mainScala run customer
  // Expecting: "there is at least one asset where the value is more than 60"
  // Expecting: "the sum of the asset values is more than 100"
}