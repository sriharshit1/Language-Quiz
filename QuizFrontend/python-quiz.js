let currentQuestionIndex = 0;
let questions = [];
let correctAnswers = 0;
let totalQuestions = 0;

async function fetchQuestion(){
    try{
        const response = await fetch('http://localhost:8080/api/questions/python');
        if(!response.ok){
            throw new Error('Network response was not ok');
        }
        questions = await response.json();
        totalQuestions = questions.length;
        document.getElementById('total-questions').textContent = totalQuestions;
        
        displayQuestion();
    }
    catch(error){
        console.error('Error fetching questions:',error);
        document.getElementById('question-text').textContent = "Failed to load questions.Please try again";
    }
}

function displayQuestion(){
    if(questions.length===0) return;

    const questionText = document.getElementById('question-text');
    const optionsContainer = document.getElementById('options-container');
    const currentQuestion = questions[currentQuestionIndex];

    questionText.textContent = currentQuestion.questionText;
    optionsContainer.innerHTML = '';

    currentQuestion.options.forEach(option =>{
        const button = document.createElement('button');
        button.textContent = option;
        button.className='option';
        button.onclick = ()=> checkAnswer(option);
        optionsContainer.appendChild(button);
    });
    document.getElementById('current-question').textContent = currentQuestionIndex+1;
}

function checkAnswer(selectedOption){
    const currentQuestion = questions[currentQuestionIndex];

    if(selectedOption === currentQuestion.correctAnswer){
        correctAnswers++;
    }
    nextQuestion();
}

function nextQuestion(){
    if(currentQuestionIndex < questions.length - 1){
        currentQuestionIndex++;
        displayQuestion();
    }
    else {
        localStorage.setItem('quizScore',correctAnswers);
        localStorage.setItem('totalQuestions',totalQuestions);
        window.location.href = 'result.html';
    }
}

window.onload = fetchQuestion();