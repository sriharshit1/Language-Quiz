let currentQuestionIndex = 0;
let questions = [];
let correctAnswers = 0; //variavle to track the number of correct answer
let totalQuestions = 0; //this will be set dynamically based on the Api response

//function to fetch question from the api

async function fetchQuestion(){
    try{
        const response = await fetch('http://localhost:8080/api/questions/java'); //Api url
        if(!response.ok){
            throw new Error('Network response was not Ok');
        }
        questions = await response.json();   //Assume API returns an array of question objects
        totalQuestions = questions.length;   //Set totalQuestions based on fetched data
        document.getElementById('total-questions').textContent = totalQuestions;        //update the total questions in the html
        
        displayQuestion();
    }
    catch(error){
        console.error('Error fetching questions:',error);
        document.getElementById('question-text').textContent = "Failed to load questions.Please try again."
    }
}

function displayQuestion(){
    if(questions.length === 0) return;

    const questionText = document.getElementById('question-text');
    const optionsContainer = document.getElementById('options-container');
    const currentQuestion = questions[currentQuestionIndex];

    //update this line to match the correct property
    questionText.textContent = currentQuestion.questionText;
    optionsContainer.innerHTML = '';    //clear previous options

    currentQuestion.options.forEach(option =>{
        const button = document.createElement('button');
        button.textContent = option;
        button.className = 'option';
        button.onclick = () => checkAnswer(option);   //call check Answer on check
        optionsContainer.appendChild(button);
    });

    document.getElementById('current-question').textContent = currentQuestionIndex +1;
}

function checkAnswer(selectedOption){
    const currentQuestion = questions[currentQuestionIndex];

    //update this line to match the correct property
    if(selectedOption === currentQuestion.correctAnswer){
        correctAnswers++;   //increment score if the answer is correct
    }

    //Automatically move to the next question after selecting an answer

    nextQuestion();
}

function nextQuestion(){
    if(currentQuestionIndex < questions.length -1){
        currentQuestionIndex++;
        displayQuestion();
    }
    else{
        //quiz completed :save the score and redirect to result page 
        localStorage.setItem('quizScore',correctAnswers);   //save the score
        localStorage.setItem('totalQuestions',totalQuestions);   //save the total questions
        window.location.href = 'result.html';   //Redirect the result page
    }
}

window.onload = fetchQuestion();