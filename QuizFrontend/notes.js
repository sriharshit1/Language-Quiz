document.addEventListener("DOMContentLoaded", () => {
    const BASE_URL = "http://localhost:8080/api"; // Change to your API base URL
    const javaNoteElement = document.getElementById('java-note');

    const fetchJavaNote = async () => {
        try {
            const response = await fetch(`${BASE_URL}/notes/java`);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            console.log(data);
            if (javaNoteElement && Array.isArray(data) && data.length>0)
                 {
                     javaNoteElement.innerHTML = data[0].content.replace(/\n/g,'<br>'); 
                    }
                     else { 
                        throw new Error('Invalid data structure or missing element');

                      };
        } catch (error) {
            console.error('Failed to fetch Java note:', error);
            if(javaNoteElement){
            javaNoteElement.textContent = 'Failed to load content.';
         }
        }
    };

    fetchJavaNote();
});
