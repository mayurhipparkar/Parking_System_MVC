<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrapFiles/bootstrap.min.css" />
<%@ include file="../module/header.jsp" %>
 <<style>
.main-container{
	width:60%;
	margin: 7% 0 0 29.5%;
}
</style>
 
<div class="container main-container">
  <div class="card shadow-lg">
    <div class="card-header bg-primary text-white">
      <h4 class="mb-0">Vehicle Entry Form</h4>
    </div>
    <div class="card-body">
      <form action="addVehicle" method="post">
        <div class="row mb-3">
          <div class="col-md-6">
            <label for="vehicleType" class="form-label">Vehicle Type</label>
            <select class="form-select" id="vehicleType" name="vehicleType" required>
              <option value="">Select</option>
              <option value="two wheeler">Two Wheeler</option>
              <option value="four wheeler">Four Wheeler</option>
            </select>
          </div>
          <div class="col-md-6">
            <label for="vehicleNumber" class="form-label">Vehicle Number</label>
            <input type="text" class="form-control" name="vehicleNumber" id="vehicleNumber" placeholder="e.g., MH12AB1234" required>
          </div>
        </div>

        <div class="row mb-3">
          <div class="col-md-6">
            <label for="ownerName" class="form-label">Owner Name</label>
            <input type="text" class="form-control" id="ownerName" name="ownerName" required>
          </div>
          <div class="col-md-6">
            <label for="contactNumber" class="form-label">Contact Number</label>
            <input type="tel" class="form-control" id="contactNumber" maxlength="10" name="contactNumber" required>
          </div>
        </div>

        <div class="row mb-3">
          <div class="col-md-6">
            <label for="entryDate" class="form-label">Entry Date </label>
            <input type="date" class="form-control" id="entryTime" name="entryDate" required>
          </div>
          <div class="col-md-6">
            <label for="entryTime" class="form-label">Entry Time</label>
            <input type="time" class="form-control" id="entryTime" name="entryTime" required>
          </div>
         
        </div>
        <div class="text-end">
          <button type="submit" class="btn btn-success">Submit Entry</button>
          <button type="reset" class="btn btn-secondary">Reset</button>
        </div>
      </form>
    </div>
  </div>
</div>

<%@ include file="../module/footer.jsp" %>
    <script src="${pageContext.request.contextPath}/bootstrapFiles/bootstrap.bundle.min.js"></script>