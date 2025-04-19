function handleSearchInput(value) {
    if (value.length > 1) {
        sendSearchRequest(value);
    } else {
        clearSearchResults(); // Очищаем результаты, если меньше 3 символов
    }
}

function sendSearchRequest(query) {
    fetch('/api/v1/search?query=' + query)
        .then(response => response.json()) // Предполагаем, что сервер возвращает JSON
        .then(data => {
            displaySearchResults(data);
        })
        .catch(error => {
            console.error('Ошибка при получении данных:', error);
        });
}

function displaySearchResults(results) {
    const searchResultsDiv = document.querySelector('.search-results');
    searchResultsDiv.innerHTML = ''; // Очищаем предыдущие результаты

    if (results.length === 0) {
        searchResultsDiv.innerHTML = '<p>Ничего не найдено</p>';
        return;
    }

    const ul = document.createElement('ul');
    results.forEach(book => {
        const a = document.createElement('a');
        a.href = '/books/' + book.id;
        ul.appendChild(a);
        const li = document.createElement('li');
        li.textContent = book.title + ', ' + book.authorName + '(' + book.publicationYear + ')'; // Отображаем название и автора
        a.appendChild(li);
    });

    searchResultsDiv.appendChild(ul);
}

function clearSearchResults() {
    const searchResultsDiv = document.querySelector('.search-results');
    searchResultsDiv.innerHTML = ''; // Очищаем результаты
}