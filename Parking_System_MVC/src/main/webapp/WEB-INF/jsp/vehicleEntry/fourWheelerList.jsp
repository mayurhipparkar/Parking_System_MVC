<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Vehicle Entry List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        table.table tbody, table.table tr, table.table td {
            padding: 4px 8px;
        }
        .label{
        font-size: 1.2rem;
        }
    </style>
</head>
<body>
	        
<div class="container mt-5">
	<div class="row g-2">
	    <!-- Total Records -->
	    <div class="col-md-2 d-flex align-items-center mb-4">
	        <label class="form-label mb-0 me-2 label">Total Records:</label>
	        <strong class="label">${totalItems}</strong>
	    </div>
	
	    <!-- Vehicle Number Filter -->
	    <div class="col-md-4">
	        <form method="get" action="${pageContext.request.contextPath}/list/fourWheeler-list/${type}">
	            <div class="row g-1">
	                <div class="col-md-7 col-sm-6">
	                    <input type="text" name="search" id="vehicleNumber" class="form-control"
	                           placeholder="Enter vehicle number" value="${search}">
	                    <input type="hidden" name="vehicleType" value="${type}" />
	                    <input type="hidden" name="size" value="5" />
	                </div>
	                <div class="col-md-5 col-sm-6">
	                    <button type="submit" class="btn btn-outline-warning">Search</button>
	                </div>
	            </div>
	        </form>
	    </div>
	
	    <!-- Date Filter -->
	    <div class="col-md-3">
	        <form method="get" action="${pageContext.request.contextPath}/list/fourWheeler-list/${type}">
	            <div class="row g-1">
	                <div class="col-md-7 col-sm-6">
	                    <input type="date" name="entryDate" id="entryDate" class="form-control" value="${entryDate}">
	                </div>
	                <div class="col-md-5 col-sm-6">
	                    <input type="hidden" name="vehicleType" value="${type}" />
	                    <input type="hidden" name="size" value="5" />
	                    <button type="submit" class="btn btn-outline-warning">Search</button>
	                </div>
	            </div>
	        </form>
	    </div>
	    
	    <!-- All target Button -->
		<div class="col-md-1 mb-3"">
	        <a href="${pageContext.request.contextPath}/list/fourWheeler-list/${type}" class="btn btn-outline-warning">All</a>
	    </div>
	    
	    <!-- Home Button -->
	    <div class="col-md-2 mb-3"">
	        <a href="${pageContext.request.contextPath}/list/home" class="btn btn-outline-warning">🏠 Home</a>
	    </div>
	</div>

    <!-- Card Table -->
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Four Wheeler Entry List</h4>
        </div>
        <div class="card-body">
            <table class="table table-bordered table-hover">
                <thead class="table-light">
                <tr>
                    <th>Sr NO.</th>
                    <th>ID</th>
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
                <c:forEach var="vehicle" items="${vehicleList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${vehicle.entry_id}</td>
                        <td>${vehicle.vehicle_type}</td>
                        <td>${vehicle.vehicle_number}</td>
                        <td>${vehicle.owner_name}</td>
                        <td>${vehicle.contact_number}</td>
                        <td>${vehicle.entry_date}</td>
                        <td>${vehicle.formatted_entry_time}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/vehicle/fetch-Vehicle/${vehicle.entry_id}" method="get">
                                <button type="submit" class="btn btn-sm ${vehicle.entry_date == today ? 'btn-success' : 'btn-warning'} my-1"
                                        ${vehicle.entry_date != today ? "disabled" : ""}>
                                    Update
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <!-- Pagination -->
            <c:if test="${totalPages > 0}">
                <nav>
                    <ul class="pagination justify-content-center">
                        <c:forEach begin="0" end="${totalPages - 1}" var="i">
                            <li class="page-item ${i == currentPage ? 'active' : ''}">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/list/fourWheeler-list/${type}?page=${i}&size=5&search=${search}&entryDate=${entryDate}">
                                    ${i + 1}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>
            </c:if>
        </div>
    </div>
</div>

<script>
    // Auto uppercase vehicle number
    document.getElementById("vehicleNumber").addEventListener("input", function () {
        this.value = this.value.toUpperCase();
    });
</script>

</body>
</html>
