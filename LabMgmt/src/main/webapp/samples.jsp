<div>
	<div>
		<h2>Manage Samples</h2>
	</div>
	<div>
		<button type="button" class="btn btn-default"
			ng-click="click.add=true">Add</button>
		<button type="button" class="btn btn-default" ng-click="">Edit</button>
		<button type="button" class="btn btn-default" ng-click="">Delete</button>
		<button type="button" class="btn btn-default" ng-click="">Create
			WorkOrders</button>
	</div>
	<div>
		<div ng-show="click.add" class="container">
			<form name="addSample" class="form-horizontal" ng-submit="add()">
				<p>Form to Add a Sample</p>
				<div class="form-group">
				
					<label class="control-label col-sm-2" for="name">Name:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="name" required placeholder="Name of the sample" ng-model="sample.name" />
					</div>
					
					<label class="control-label col-sm-2" for="customer">Customer:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="customer" required placeholder="Customer" ng-model="sample.custName" />
					</div>
					
					<label class="control-label col-sm-2" for="form">Form:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="form" placeholder="Form" ng-model="sample.form" />
					</div>
					
					<label class="control-label col-sm-2" for="size">Size:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="size" placeholder="Size" ng-model="sample.size" />
					</div>
					
					<label class="control-label col-sm-2" for="stamping">Stamping:</label>
					<div class="col-sm-5">
					<input class="form-control" type="text" name="stamping" placeholder="Stamping" ng-model="sample.stamping" />
					</div>
					
					
					<label class="control-label col-sm-2" for="toBeReturned">Is To Be Returned?</label>
					<div class="col-sm-5">
					<input type="radio" name="toBeReturned" ng-model="sample.toBeReturned" value="true">Yes
  					<input type="radio" name="toBeReturned" ng-model="sample.toBeReturned" value="false">No
  					</div>
  
					<label class="control-label col-sm-2" for="receivedDate">Received Date:</label>
					<div class="col-sm-5">
					<input class="form-control" type="date" name="receivedDate" placeholder="Received Date" ng-model=" sample.receivedDate"/>
					</div>
					
					
					
					Status: <input class="form-control" type="text" placeholder="Status"ng-model="sample.status" /><br> 
					Description: <textarea class="form-control" placeholder="Describe the sample" rows="4" cols="50" ng-model="sample.sampleDescription"></textarea>
					<br>
					<br>
					<button type="submit" class="btn btn-default">Save</button>
					<button type="button" class="btn btn-default"
						ng-click="click.add=false">Cancel</button>
				</div>
			</form>
		</div>
	</div>
	<div>
		<select ng-model="samplesSortOrder">
			<option value="+sampleId">Id</option>
			<option value="-sampleId">Id (dec)</option>
			<option value="+sampleName">Name</option>
			<option value="-sampleName">Name (dec)</option>
			<option value="+custName">Customer Name</option>
			<option value="-custName">Customer Name (dec)</option>
		</select>

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Customer Name</th>
					<th>Form</th>
					<th>Size</th>
					<th>Stamping</th>
					<th>To be Returned</th>
					<th>Received Date</th>
					<th>Status</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="sample in samples">
					<td>{{ sample.sampleId }}</td>
					<td>{{ sample.sampleName}}</td>
					<td>{{ sample.custName }}</td>
					<td>{{ sample.form }}</td>
					<td>{{ sample.size }}</td>
					<td>{{ sample.stamping }}</td>
					<td>{{ sample.toBeReturned }}</td>
					<td>{{ sample.receivedDate }}</td>
					<td>{{ sample.status }}</td>
					<td>{{ sample.sampleDescription }}</td>
				</tr>

			</tbody>
		</table>

	</div>

</div>