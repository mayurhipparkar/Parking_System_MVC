<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Vehicle Entry List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-5">
  <div class="card shadow-lg">
    <div class="card-header bg-primary text-white">
      <h4 class="mb-0">Vehicle Entry List</h4>
    </div>
    <div class="card-body">
      <table class="table table-bordered table-hover">
        <thead class="table-light">
        <tr>
         <th>Sr No.</th>
        <th>Vehicle Type</th>
          <th>Vehicle Number</th>
          <th>Owner Name</th>
          <th>Contact Number</th>
          <th>Entry Date</th>
          <th>Entry Time</th>
          <th>Action</th>
		  
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vehicle" items="${vehicleList}">
          <tr>
           <td>${vehicle.entry_id}</td>
          <td>${vehicle.vehicle_type}</td>
            <td>${vehicle.vehicle_number}</td>
            <td>${vehicle.owner_name}</td>
            <td>${vehicle.contact_number}</td>
            <td>${vehicle.entry_date}</td>
            <td>${vehicle.entry_time}</td>
           <td>
              <a href="updateVehicle?id=${vehicle.entry_id}" class="btn btn-sm btn-warning my-1">Update</a>
              <a href="deleteVehicle?id=${vehicle.entry_id}" class="btn btn-sm btn-danger"
                 onclick="return confirm('Are you sure you want to delete this entry?');">Delete</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
    