import {
    DropdownMenu,
    DropdownMenuContent,
    DropdownMenuItem,
    DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu"
import { ChevronDown, Pencil, Trash } from "lucide-react"


export default function CrudDropdown() {
    return (
        <DropdownMenu>
            <DropdownMenuTrigger>
                <ChevronDown />
            </DropdownMenuTrigger>
            <DropdownMenuContent>
                <DropdownMenuItem>
                    <Pencil />
                    editar
                </DropdownMenuItem>
                <DropdownMenuItem>
                    <Trash />
                    apagar
                </DropdownMenuItem>
            </DropdownMenuContent>
        </DropdownMenu>

    )
}