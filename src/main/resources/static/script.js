document.addEventListener("DOMContentLoaded", function () {
    const viewExceptionsBtn = document.getElementById("viewExceptionsBtn");
    const modal = document.getElementById("myModal");
    const closeButton = document.querySelector(".close");
    const searchInput = document.getElementById("searchInput");
    const exceptionBody = document.getElementById("exceptionBody");

    viewExceptionsBtn.addEventListener("click", function () {
        // Fetch exceptions from the backend
        fetch('/api/push-notifications')
            .then(response => response.json())
            .then(data => {
                // Populate modal with exception data
                populateModal(data);
                // Show modal
                modal.style.display = "block";
            })
            .catch(error => console.error('Error fetching exceptions:', error));
    });

    closeButton.addEventListener("click", function () {
        // Close modal
        modal.style.display = "none";
    });

    window.addEventListener("click", function (event) {
        // Close modal if clicked outside the modal content
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });

    searchInput.addEventListener("keyup", function () {
        const searchText = searchInput.value.toLowerCase();
        const exceptionRows = document.querySelectorAll("#exceptionBody tr");
        exceptionRows.forEach(row => {
            const username = row.dataset.username.toLowerCase();
            const source = row.dataset.source.toLowerCase();
            if (username.includes(searchText) || source.includes(searchText)) {
                row.style.display = "table-row";
            } else {
                row.style.display = "none";
            }
        });
    });

    function populateModal(exceptions) {
        // Clear previous exception table body
        exceptionBody.innerHTML = '';

        // Populate modal with exception data
        exceptions.forEach(exception => {
            exception.info.forEach(info => {
                const row = document.createElement("tr");
                row.dataset.username = exception.username;
                row.dataset.source = exception.source;

                const usernameCell = document.createElement("td");
                usernameCell.textContent = exception.username;
                row.appendChild(usernameCell);

                const sourceCell = document.createElement("td");
                sourceCell.textContent = exception.source;
                row.appendChild(sourceCell);

                const exceptionCell = document.createElement("td");
                exceptionCell.textContent = info.message;
                row.appendChild(exceptionCell);

                const timestampCell = document.createElement("td");
                timestampCell.textContent = new Date(info.timestamp).toLocaleString();
                row.appendChild(timestampCell);

                const projectIdCell = document.createElement("td");
                projectIdCell.textContent = info.projectId;
                row.appendChild(projectIdCell);

                exceptionBody.appendChild(row);
            });
        });
    }
});
