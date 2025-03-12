function startQuiz(quizType){
    alert(`Starting ${quizType.charAt(0).toUpperCase() + quizType.slice(1)} Quiz!`);

    //Redirecting to the corresponding quiz page based on the selected type

    window.location.href = `${quizType}-quiz.html`; //Assumes pages are named java-quiz.html , python-quiz.html etc...
}

function OpeningNotes(quizType){
    window.location.href = 'notes.html';
}