import PropTypes from 'prop-types'

function Botao({onClick, tipo, children}){

    const obterTipo = () => {
        return ['success', 'danger', 'warning'].includes(tipo) ? tipo : 'default';
    }
    
    return (
        <button className={`btn btn-${obterTipo()} btn-sm`} onClick={onClick}>{children}</button>
    )
}

Botao.propTypes = {
    onClick: PropTypes.any,
    tipo: PropTypes.string,
    children: PropTypes.string
}

export default Botao