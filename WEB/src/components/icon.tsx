import * as LucideIcons from 'lucide-react'

interface IconProps{
    name: string
}

export default function Icon({name} : IconProps){
    const LucideIcon = (LucideIcons as any)[name]

    if (!LucideIcon) return <LucideIcons.Ban color='red' />

    return <LucideIcon />
}