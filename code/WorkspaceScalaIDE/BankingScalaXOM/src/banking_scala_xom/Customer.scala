package banking_scala_xom

import scala.collection.mutable.ListBuffer

class Asset(value2: Int) {
  var value = value2
}

trait AssetOwner {
  var assets: Array[Asset]

  def sumAssetValues = {
    if (assets.length > 0) assets map (_.value) reduce (_ + _)
    else 0
  }
}

class Customer(accountBalance: Int) {
  var alerts: ListBuffer[String] = ListBuffer()
  def totalBalance = accountBalance

  // Verbalization-friendly methods
  def addAlert(alert: String): Unit = alerts += alert
  // Return type Unit, else will be considered a ListBuffer and we will not be allowed to verbalize it
  
  def clearAlerts = alerts.clear
}

class CustomerOwningAssets(accountBalance: Int, assets2: Array[Asset]) extends Customer(accountBalance) with AssetOwner {
  override var assets = assets2
  override def totalBalance = sumAssetValues + accountBalance
}
