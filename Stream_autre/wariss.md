var intervalle = setInterval(function() {
    // Vérifie si un mot est mis en surbrillance
    if (document.querySelector('.highlight')) {
        // Récupère le texte du mot
        let mot = document.querySelector('.highlight').textContent;
        // L'injecte dans le champ de saisie
        let champSaisie = document.querySelector('#inputfield');
        champSaisie.value = mot + ' ';
        
        // Simule l'événement de saisie pour que le site valide le mot
        let evenement = new Event('input', { bubbles: true });
        champSaisie.dispatchEvent(evenement);
    } else {
        // Arrête le script si le test est fini
        clearInterval(intervalle);
    }
}, 100); // 100 millisecondes entre chaque mot (ajustable)

