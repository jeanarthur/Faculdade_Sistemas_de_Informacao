import PropTypes from 'prop-types'

function TituloDaPagina({children}){
    return(<h2>{children}</h2>)
}

TituloDaPagina.propTypes = {
    children: PropTypes.string
}

export default TituloDaPagina;